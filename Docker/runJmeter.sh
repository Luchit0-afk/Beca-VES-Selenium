#!/bin/bash

#
# Test the JMeter Docker image using a trivial test plan.
# Example for using User Defined Variables with JMeter
# These will be substituted in JMX test script
# 

export THREADS="20"
export RAMPUP="20"
export DURATION="240"
export SCRIPT="jemeterTests/ENTRAR-LISTA-DE-EVALUACIONES.jmx"
export JTL="jemeterTests/ENTRAR-LISTA-DE-EVALUACIONES.jtl"
export LOG="jemeterTests/ENTRAR-LISTA-DE-EVALUACIONES.log"

rm -f ${JTL} ${LOG}

./run.sh \
	-n -t ${SCRIPT} \
	-l ${JTL} \
	-j ${LOG} \
	-Jthreads=${THREADS} \
	-Jrampup=${RAMPUP} \
	-Jduration=${DURATION}