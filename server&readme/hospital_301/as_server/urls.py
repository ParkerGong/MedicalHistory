# as_server/urls.py
from django.urls import path
from . import views

app_name = 'as_server'

urlpatterns = [
    path('connect/', views.connect, name='connect'),
    path('text_recv/', views.text_recv, name='text_recv'),
    path('picture_recv/', views.picture_recv, name='picture_recv'),
    path('docter_send_text/', views.docter_send_text, name='docter_send_text'),
    path('docter_send_imag/', views.docter_send_imag, name='docter_send_imag'),
    path('create_doc/', views.create_doc, name='create_doc'),
]



