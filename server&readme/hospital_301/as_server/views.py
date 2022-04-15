# coding=utf-8
from django.shortcuts import render
from django.http import HttpResponse
from utils import get_db_handle
import simplejson
import sys,base64,json,os
from bson import json_util
import re
from docxtpl import DocxTemplate
from .tasks import save_picture, save_text

# Create your views here.
def connect(request):
    if request.method == "GET":
        print("connect")
        return render(request,'as_server/test.html')

    elif request.method == 'POST':
        result = json.loads(request.body)
        print(result)
        return HttpResponse("connect")
    return HttpResponse("not right")



def text_recv(request):
    if request.method == "GET":
        print("connect")
        return HttpResponse("connect")

    elif request.method == 'POST':
            result = json.loads(request.body)
            # print(result)
            db_handle, client = get_db_handle("hospital_301", "127.0.0.1", "27017")
            # print("rerer")
            # save_text.delay(result)

            create_text_table(db_handle,result)

    return HttpResponse("you are in")


def picture_recv(request):
    if request.method == 'GET':
        return render(request, 'as_server/test.html')
    elif request.method == 'POST':
        # print(request.headers)
        files = request.FILES.getlist('file')
        if files:
            # print("1111111111111111")
            if not os.path.exists("E:/patientpicture/"):         #创建目录
                os.makedirs("E:/patientpicture/")

            for f in files:
                if f:
                    destination = open(os.path.join("E:/patientpicture/", f.name),'wb+')
                    for chunk in f.chunks():
                        destination.write(chunk)
                    destination.close()

            # patient_ID = request.headers["PatientID"]
            # db_handle, client = get_db_handle("hospital_301", "127.0.0.1", "27017")
            # create_picture_table(db_handle, "E:/patientpicture/", "5")
            return HttpResponse('ok')


        else :
            # print("222222222222222")
            name = request.headers['Filename']
            chuanghao = request.headers['chuanghao']
            # name = "555"
            # chuanghao ="31asd"
            save_picture.delay(request.body, chuanghao, name)
            # print(request.body)
            # print(len(request.body))

            # picture_address= 'E:/patientpicture/' + '/'+ str(chuanghao[:-3])+ '床/'
            # if not os.path.exists(picture_address):         #创建目录
            #     os.makedirs(picture_address)
            # # print(name)
            # with open('E:/patientpicture/' + '/'+ str(chuanghao[:-3])+ '床/' + name +  '.jpeg', 'wb') as fh1:
            #     fh1.write(request.body)
            # fh1.close()

            return HttpResponse("file")


def picture_delete(path_data):
    for i in os.listdir(path_data) :# os.listdir(path_data)#返回一个列表，里面是当前目录下面的所有东西的相对路径
        file_data = path_data + "\\" + i#当前文件夹的下面的所有东西的绝对路径
        if os.path.isfile(file_data) == True:#os.path.isfile判断是否为文件,如果是文件,就删除.如果是文件夹.递归给del_file.
            os.remove(file_data)
        else:
            picture_delete(file_data)


def create_text_table(db_handle,message):
    # First define the database name
    dbname = db_handle
    collection_name = dbname["medicinedetails"]

    patient_chuanghao = collection_name.count_documents({"chuanghao" : message["chuanghao"]})

    if patient_chuanghao != 0 :
        collection_name.update({"chuanghao":message["chuanghao"]},message)

        try:
            delete_address = str('E:/patientpicture/' + '/'+ str(message["chuanghao"][:-1]) + '床' )
            picture_delete(delete_address)
        except:
            pass
    else:
        # Insert the documents
        collection_name.insert_one(message)



def create_picture_table(db_handle, address,chuanghao):
    # First define the database name
    dbname = db_handle
    collection_name = dbname["medicinedetails"]

    # Update one document
    collection_name.update({"chuanghao":str(chuanghao)},{"$set":{'picture address': address}},)



def docter_send_imag(request):
    if request.method == "GET":
        print("connect")
        return HttpResponse("connect")
    elif request.method == 'POST':
        # result = json.loads(request.body)
        name = request.headers['Filename']
        chuanghao = request.headers['chuanghao']
        # print(chuanghao[0])

        picture_address = 'E:/patientpicture/' +  str(chuanghao[:-3])+ '床/' + name
        # print(picture_address)

        try:
            with open(picture_address +  '.jpeg', 'rb') as fh1:
                bytes1 = fh1.read()
        except:
            with open('E:/patientpicture/' + "no file" '.png', 'rb') as fh1:
                bytes1 = fh1.read()

        return HttpResponse(bytes1,content_type='image/png')



def docter_send_text(request):
    if request.method == "GET":
        print("connect")
        return HttpResponse("connect")
    elif request.method == 'POST':
        result = json.loads(request.body)
        chuanghao1 = result['chuanghao']


        db_handle, client = get_db_handle("hospital_301", "127.0.0.1", "27017")
        med_detail = docter_get_msg(db_handle, chuanghao1)

        data = json_util.dumps(med_detail)
        # print(med_detail)

        return HttpResponse(data)


def create_doc(request):
    if request.method == "GET":
        print("connect")
        return HttpResponse("connect")
    elif request.method == 'POST':

        result = json.loads(request.body)
        # print(result)
        patient_name = result['name']
        patient_ID = result["PatientID"]
        chuanghao = result["chuanghao"]

        if not os.path.exists("E:/patientdoc/"):  # 创建目录
            os.makedirs("E:/patientdoc/")

        address = "E:/patientdoc/ " +str(chuanghao) + "-" + str(patient_name) + "-" + str(patient_ID)
        doc = DocxTemplate("E:/patientdoc/tp1.docx")  # 加载模板文件
        doc.render(result)  # 填充数据
        doc.save(address + '.docx')  # 保存目标文件
        return HttpResponse("ok")


def docter_get_msg(db_handle,chuanghao):
    dbname = db_handle
    collection_name = dbname["medicinedetails"]

    # Read the documents
    med_details = collection_name.find_one({"chuanghao":chuanghao})
    # print(med_details)

    return med_details


