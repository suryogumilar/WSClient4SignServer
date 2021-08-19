# Web Service Client untuk Signserver

Signserver yg digunakan adalah versi 5.2.0

## Generate Client using eclipse IDE

pertama buat project Maven, set package ke war di pom.xml nya

## prerequisite untuk Eclipse

 - set server runtime, apache or others.   
 - Untuk set CXF ada di `Window > Preferences > Web Services > CXF Preferences`

## step to generate client code
 - download binary untuk Apache CXF unzip
 - setelah wsdl diimport, klik WebService-> generate client
 - pilih Apache CXF 2.x dan arahkan ke binary yg telah didownload
 
## Reference
