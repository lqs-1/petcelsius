from django.contrib import admin
from apps.userBack.models import User, IndexBanner, IndexNavigate, IndexFloor, IndexFloorDetail, IndexFloorImage, HeartDetail, HeartInfo, PetCooperateInfo, PetCooperateDescImg

# Register your models here.

admin.site.register(User)
admin.site.register(IndexBanner)
admin.site.register(IndexNavigate)
admin.site.register(IndexFloor)
admin.site.register(IndexFloorImage)
admin.site.register(IndexFloorDetail)
admin.site.register(HeartDetail)
admin.site.register(HeartInfo)
admin.site.register(PetCooperateInfo)
admin.site.register(PetCooperateDescImg)

