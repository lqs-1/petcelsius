# Generated by Django 4.0.3 on 2022-04-20 02:09

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0013_indexfloordetail_name'),
    ]

    operations = [
        migrations.CreateModel(
            name='HeartDetail',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True, null=True, verbose_name='创建时间')),
                ('alter_time', models.DateTimeField(auto_now=True, null=True, verbose_name='更新时间')),
                ('del_mark', models.BooleanField(default=False, null=True, verbose_name='删除标记')),
                ('name', models.CharField(max_length=30, verbose_name='占位')),
            ],
            options={
                'abstract': False,
            },
        ),
        migrations.CreateModel(
            name='PetInfo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True, null=True, verbose_name='创建时间')),
                ('alter_time', models.DateTimeField(auto_now=True, null=True, verbose_name='更新时间')),
                ('del_mark', models.BooleanField(default=False, null=True, verbose_name='删除标记')),
            ],
            options={
                'abstract': False,
            },
        ),
        migrations.CreateModel(
            name='HeartInfo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True, null=True, verbose_name='创建时间')),
                ('alter_time', models.DateTimeField(auto_now=True, null=True, verbose_name='更新时间')),
                ('del_mark', models.BooleanField(default=False, null=True, verbose_name='删除标记')),
                ('title', models.CharField(choices=[('宠物动态', '宠物动态'), ('军犬风采', '军犬风采')], default='宠物动态', max_length=30, verbose_name='标题')),
                ('name', models.CharField(max_length=20, verbose_name='宠物名称')),
                ('age', models.IntegerField(verbose_name='宠物年龄')),
                ('color', models.CharField(max_length=20, verbose_name='宠物颜色')),
                ('desc', models.TextField(null=True, verbose_name='宠物描述')),
                ('detail', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, to='userBack.heartdetail', verbose_name='缅怀详情')),
                ('user', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='userBack.user', verbose_name='用户id')),
            ],
            options={
                'verbose_name': '缅怀基本信息',
                'verbose_name_plural': '缅怀基本信息',
                'db_table': 'heart_info',
            },
        ),
    ]
