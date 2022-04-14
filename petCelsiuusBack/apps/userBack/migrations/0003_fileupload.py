# Generated by Django 4.0.3 on 2022-04-11 11:25

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0002_alter_user_table'),
    ]

    operations = [
        migrations.CreateModel(
            name='FileUpload',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('image', models.FileField(max_length=1000, upload_to='', verbose_name='图片上传')),
            ],
            options={
                'db_table': 'file',
            },
        ),
    ]