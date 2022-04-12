from django.contrib import admin
from apps.userBack.models import User, IndexBanner, IndexNavigate

# Register your models here.

admin.site.register(User)
admin.site.register(IndexBanner)
admin.site.register(IndexNavigate)
