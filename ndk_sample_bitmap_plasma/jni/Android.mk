LOCAL_PATH := $(call my-dir)
include $(call all-subdir-makefiles)
include $(CLEAR_VARS)

LOCAL_MODULE    := plasma
LOCAL_SRC_FILES := plasma.c
LOCAL_LDLIBS    := -lm -llog -ljnigraphics

include $(BUILD_SHARED_LIBRARY)
