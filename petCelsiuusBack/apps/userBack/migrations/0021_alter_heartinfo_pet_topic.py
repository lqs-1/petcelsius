# Generated by Django 4.0.3 on 2022-04-26 07:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0020_heartinfo_pet_topic'),
    ]

    operations = [
        migrations.AlterField(
            model_name='heartinfo',
            name='pet_topic',
            field=models.ImageField(max_length=101, upload_to='', verbose_name='宠物展示图片'),
        ),
    ]