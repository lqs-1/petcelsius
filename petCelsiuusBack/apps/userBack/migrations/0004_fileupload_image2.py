# Generated by Django 4.0.3 on 2022-04-11 12:25

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0003_fileupload'),
    ]

    operations = [
        migrations.AddField(
            model_name='fileupload',
            name='image2',
            field=models.ImageField(default='ddd', upload_to='', verbose_name='上传'),
        ),
    ]
