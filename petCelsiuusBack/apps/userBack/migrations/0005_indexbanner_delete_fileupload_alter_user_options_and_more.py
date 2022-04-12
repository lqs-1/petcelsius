# Generated by Django 4.0.3 on 2022-04-11 12:38

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0004_fileupload_image2'),
    ]

    operations = [
        migrations.CreateModel(
            name='IndexBanner',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True)),
                ('alter_time', models.DateTimeField(auto_now=True)),
                ('del_mark', models.BooleanField(default=False)),
                ('name', models.CharField(max_length=30, unique=True, verbose_name='banner名称')),
                ('image', models.ImageField(upload_to='', verbose_name='banner图')),
                ('index', models.IntegerField(default=1, verbose_name='排序')),
            ],
            options={
                'verbose_name': '首页banner',
                'verbose_name_plural': '首页banner',
                'db_table': 'index_banner',
            },
        ),
        migrations.DeleteModel(
            name='FileUpload',
        ),
        migrations.AlterModelOptions(
            name='user',
            options={'verbose_name': '用户', 'verbose_name_plural': '用户'},
        ),
        migrations.AlterField(
            model_name='user',
            name='mobile',
            field=models.CharField(max_length=20, unique=True, verbose_name='电话号码'),
        ),
        migrations.AlterField(
            model_name='user',
            name='topic',
            field=models.TextField(verbose_name='头像'),
        ),
        migrations.AlterField(
            model_name='user',
            name='username',
            field=models.CharField(max_length=30, verbose_name='用户名'),
        ),
    ]
