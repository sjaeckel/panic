obj-m := panic.o
# LINUX_SRC := /lib/modules/$(shell uname -r)/build
PWD := $(shell pwd)

ifeq ("$(LINUX_SRC)","")
	LINUX_SRC:=$(KERNEL_PATH)
endif

default: modules

modules:
	$(MAKE) -C $(LINUX_SRC) M=$(PWD) modules

clean:
	$(MAKE) -C $(LINUX_SRC) M=$(PWD) clean
