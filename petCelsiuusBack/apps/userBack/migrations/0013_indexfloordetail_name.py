# Generated by Django 4.0.3 on 2022-04-13 09:53

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0012_indexfloorimage_floor_img'),
    ]

    operations = [
        migrations.AddField(
            model_name='indexfloordetail',
            name='name',
            field=models.CharField(default=1, max_length=30, verbose_name='占位'),
            preserve_default=False,
        ),
    ]
