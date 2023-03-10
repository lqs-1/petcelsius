# Generated by Django 4.0.3 on 2022-04-11 12:41

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0005_indexbanner_delete_fileupload_alter_user_options_and_more'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='indexbanner',
            name='alter_time',
        ),
        migrations.RemoveField(
            model_name='user',
            name='alter_time',
        ),
        migrations.AddField(
            model_name='indexbanner',
            name='update_time',
            field=models.DateTimeField(auto_now=True, verbose_name='更新时间'),
        ),
        migrations.AddField(
            model_name='user',
            name='update_time',
            field=models.DateTimeField(auto_now=True, verbose_name='更新时间'),
        ),
        migrations.AlterField(
            model_name='indexbanner',
            name='create_time',
            field=models.DateTimeField(auto_now_add=True, verbose_name='创建时间'),
        ),
        migrations.AlterField(
            model_name='indexbanner',
            name='del_mark',
            field=models.BooleanField(default=False, verbose_name='删除标记'),
        ),
        migrations.AlterField(
            model_name='user',
            name='create_time',
            field=models.DateTimeField(auto_now_add=True, verbose_name='创建时间'),
        ),
        migrations.AlterField(
            model_name='user',
            name='del_mark',
            field=models.BooleanField(default=False, verbose_name='删除标记'),
        ),
    ]
