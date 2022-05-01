# Generated by Django 4.0.3 on 2022-04-26 06:09

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0017_petcooperatedescimg_petcooperateinfo_desc_and_more'),
    ]

    operations = [
        migrations.CreateModel(
            name='HeartLogo',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('create_time', models.DateTimeField(auto_now_add=True, null=True, verbose_name='创建时间')),
                ('alter_time', models.DateTimeField(auto_now=True, null=True, verbose_name='更新时间')),
                ('del_mark', models.BooleanField(default=False, null=True, verbose_name='删除标记')),
                ('title', models.CharField(choices=[('宠物狗', '宠物狗'), ('宠物猫', '宠物猫'), ('功勋犬', '功勋犬')], default='宠物狗', max_length=30, verbose_name='标题')),
                ('logo', models.ImageField(upload_to='', verbose_name='缅怀展示logo')),
            ],
            options={
                'verbose_name': '缅怀logo',
                'verbose_name_plural': '缅怀logo',
                'db_table': 'heart_logo',
            },
        ),
        migrations.AlterField(
            model_name='heartinfo',
            name='title',
            field=models.CharField(choices=[('宠物狗', '宠物狗'), ('宠物猫', '宠物猫'), ('功勋犬', '功勋犬')], default='宠物狗', max_length=30, verbose_name='标题'),
        ),
    ]