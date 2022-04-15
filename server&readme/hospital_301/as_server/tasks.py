from celery.task import task
import os
from utils import get_db_handle



# 自定义要执行的task任务
@task(name="save_picture")
def save_picture(picture, chuanghao, name):
    picture_address = 'E:/patientpicture' + '/' + str(chuanghao[:-3]) + '床/'
    if not os.path.exists(picture_address):  # 创建目录
        os.makedirs(picture_address)
    # print(name)
    with open('E:/patientpicture' + '/' + str(chuanghao[:-3]) + '床/' + name + '.jpeg', 'wb') as fh1:
        fh1.write(picture)
    fh1.close()

