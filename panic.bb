SUMMARY = "Can I haz kernel panic plz?"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

DEPENDS += "virtual/kernel"

inherit module

PR = "r0"
PV = "0.1"

SRCREV = "master"

SRC_URI += " \
	git://github.com/sjaeckel/panic.git;protocol=http \
	"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "-C . ARCH='${ARCH}'"

FILES_${PN} += "lib"

do_configure() {
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/misc
	cp ${S}/*.ko ${D}/lib/modules/${KERNEL_VERSION}/misc/panic.ko
}

PROVIDES += "kernel-module-panic"
RPROVIDES_${PN} += "kernel-module-panic"
RREPLACES_${PN} += "kernel-module-panic"

KERNEL_MODULE_AUTOLOAD += "panic"
