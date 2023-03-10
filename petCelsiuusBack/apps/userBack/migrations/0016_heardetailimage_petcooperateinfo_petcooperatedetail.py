# Generated by Django 4.0.3 on 2022-04-20 11:44

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0015_alter_heartdetail_options_alter_heartdetail_table'),
    ]

    operations = [
        migrations.CreateModel(
            name='HearDetailImage',
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
            name='PetCooperateInfo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True, null=True, verbose_name='创建时间')),
                ('alter_time', models.DateTimeField(auto_now=True, null=True, verbose_name='更新时间')),
                ('del_mark', models.BooleanField(default=False, null=True, verbose_name='删除标记')),
                ('title', models.CharField(max_length=30, verbose_name='机构名称')),
                ('logo', models.ImageField(upload_to='', verbose_name='机构logo')),
                ('contact', models.CharField(max_length=20, verbose_name='联系电话')),
                ('address', models.CharField(max_length=50, verbose_name='机构地址')),
            ],
            options={
                'verbose_name': '合作机构信息',
                'verbose_name_plural': '合作机构信息',
                'db_table': 'cooperate_info',
            },
        ),
        migrations.CreateModel(
            name='PetCooperateDetail',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True, null=True, verbose_name='创建时间')),
                ('alter_time', models.DateTimeField(auto_now=True, null=True, verbose_name='更新时间')),
                ('del_mark', models.BooleanField(default=False, null=True, verbose_name='删除标记')),
                ('name', models.CharField(max_length=30, verbose_name='占位')),
                ('petCooperate', models.OneToOneField(on_delete=django.db.models.deletion.CASCADE, to='userBack.petcooperateinfo', verbose_name='所属机构')),
            ],
            options={
                'verbose_name': '合作机构详情',
                'verbose_name_plural': '合作机构详情',
                'db_table': 'cooperate_detail',
            },
        ),
    ]
