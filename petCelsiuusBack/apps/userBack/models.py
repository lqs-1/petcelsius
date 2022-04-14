from django.db import models
from db.BaseDb import BaseDB
# Create your models here.


# 用户表
class User(BaseDB, models.Model):
    username = models.CharField(max_length=30, null=False, verbose_name="用户名")
    mobile = models.CharField(max_length=20, unique=True, verbose_name="电话号码")
    topic = models.TextField(verbose_name="头像", null=True)

    class Meta:
        db_table = "user"
        verbose_name = "用户"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.username


# 文件上传测试表
# class FileUpload(models.Model):
#     image = models.FileField(max_length=1000, verbose_name="图片上传")
#     image2 = models.ImageField(verbose_name="上传", default="ddd")
#
#     class Meta:
#         db_table = "file"


# 首页banner
class IndexBanner(BaseDB, models.Model):

    name = models.CharField(max_length=30, null=False, verbose_name="banner名称", unique=True)
    image = models.ImageField(verbose_name="banner图", null=False)
    index = models.IntegerField(verbose_name="排序", default=1, null=False)

    class Meta:
        db_table = "index_banner"
        verbose_name = "首页banner"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.name


# 首页导航栏 就是服务的图标
class IndexNavigate(BaseDB, models.Model):

    title = models.CharField(max_length=30, null=False, verbose_name="导航名称", unique=True)
    icon = models.ImageField(verbose_name="导航图片", null=False)
    index = models.IntegerField(verbose_name="排序", default=1, null=False)

    class Meta:
        db_table = "index_navigate"
        verbose_name = "首页导航栏"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.title


# 首页楼层基本信息
class IndexFloor(BaseDB, models.Model):

    title = models.CharField(max_length=30, null=False, verbose_name="楼层名称", unique=True)
    title_img = models.ImageField(null=False, verbose_name="楼层标题logo")
    floor_index_img = models.ImageField(null=False, verbose_name="楼层示图")
    index = models.IntegerField(verbose_name="排序", default=1, null=False)

    class Meta:
        db_table = "index_floor"
        verbose_name = "首页楼层"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.title


# 首页楼层图片
class IndexFloorImage(BaseDB, models.Model):

    floor = models.ForeignKey('IndexFloor', verbose_name='所属楼层', on_delete=models.CASCADE)
    detail = models.OneToOneField("IndexFloorDetail", verbose_name="所有内容", on_delete=models.CASCADE)
    floor_img = models.ImageField(null=False, verbose_name="楼层内容图")
    index = models.IntegerField(verbose_name="排序", default=1, null=False)

    class Meta:
        db_table = "index_floor_img"
        verbose_name = "首页楼层图片"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.detail.name


# 首页楼层详情
class IndexFloorDetail(BaseDB, models.Model):

    name = models.CharField(max_length=30, verbose_name="占位", null=False)

    class Meta:
        db_table = "index_floor_detail"
        verbose_name = "首页楼层详情"
        verbose_name_plural = verbose_name

    def __str__(self):
        return self.name