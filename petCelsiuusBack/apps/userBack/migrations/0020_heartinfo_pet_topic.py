# Generated by Django 4.0.3 on 2022-04-26 07:30

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0019_rename_heardetailimage_heartdetailimage_and_more'),
    ]

    operations = [
        migrations.AddField(
            model_name='heartinfo',
            name='pet_topic',
            field=models.ImageField(default='htpps://fewfaf', upload_to='', verbose_name='宠物展示图片'),
            preserve_default=False,
        ),
    ]
