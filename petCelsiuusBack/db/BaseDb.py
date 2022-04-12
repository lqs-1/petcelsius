from django.db import models


class BaseDB(models.Model):
    create_time = models.DateTimeField(auto_now_add=True, verbose_name='创建时间', null=True)
    alter_time = models.DateTimeField(auto_now=True, verbose_name='更新时间', null=True)
    del_mark = models.BooleanField(default=False, verbose_name="删除标记", null=True)

    class Meta:
        abstract = True