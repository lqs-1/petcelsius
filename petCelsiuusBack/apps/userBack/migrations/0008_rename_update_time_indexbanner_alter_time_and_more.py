# Generated by Django 4.0.3 on 2022-04-12 05:28

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('userBack', '0007_alter_indexbanner_create_time_and_more'),
    ]

    operations = [
        migrations.RenameField(
            model_name='indexbanner',
            old_name='update_time',
            new_name='alter_time',
        ),
        migrations.RenameField(
            model_name='user',
            old_name='update_time',
            new_name='alter_time',
        ),
    ]