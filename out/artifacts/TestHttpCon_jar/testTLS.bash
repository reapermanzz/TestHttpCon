#!/bin/bash
clear
echo ""
echo ""
echo ""
echo "Performing Test of TLS1.0 using JDK7u79"
java -jar TestHttpCon.jar https://tls1test.salesforce.com/s/ TLSv1

echo ""
echo ""
echo ""
echo "Performing Test of TLS1.1 using JDK7u79"
java -jar TestHttpCon.jar https://tls1test.salesforce.com/s/ TLSv1.1

echo ""
echo ""
echo ""
echo "Performing Test of TLS1.2 using JDK7u79"
java -jar TestHttpCon.jar https://tls1test.salesforce.com/s/ TLSv1.2



