from django.test import TestCase
import os
# Create your tests here.
# def picture_delete(path_data):
#     for i in os.listdir(path_data) :# os.listdir(path_data)#返回一个列表，里面是当前目录下面的所有东西的相对路径
#         file_data = path_data + "\\" + i#当前文件夹的下面的所有东西的绝对路径
#         if os.path.isfile(file_data) == True:#os.path.isfile判断是否为文件,如果是文件,就删除.如果是文件夹.递归给del_file.
#             os.remove(file_data)
#         else:
#             picture_delete(file_data)
#
# picture_delete('E:/patientpicture/' + '/15床' )