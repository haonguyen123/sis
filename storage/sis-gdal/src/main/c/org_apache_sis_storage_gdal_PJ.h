/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_apache_sis_storage_gdal_PJ */

#ifndef _Included_org_apache_sis_storage_gdal_PJ
#define _Included_org_apache_sis_storage_gdal_PJ
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    allocatePJ
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_apache_sis_storage_gdal_PJ_allocatePJ
  (JNIEnv *, jclass, jstring);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    allocateGeoPJ
 * Signature: (Lorg/apache/sis/storage/gdal/PJ;)J
 */
JNIEXPORT jlong JNICALL Java_org_apache_sis_storage_gdal_PJ_allocateGeoPJ
  (JNIEnv *, jclass, jobject);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    getRelease
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_apache_sis_storage_gdal_PJ_getRelease
  (JNIEnv *, jclass);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    getCode
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_apache_sis_storage_gdal_PJ_getCode
  (JNIEnv *, jobject);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    getType
 * Signature: ()Lorg/apache/sis/storage/gdal/PJ/Type;
 */
JNIEXPORT jobject JNICALL Java_org_apache_sis_storage_gdal_PJ_getType
  (JNIEnv *, jobject);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    getEllipsoidDefinition
 * Signature: ()[D
 */
JNIEXPORT jdoubleArray JNICALL Java_org_apache_sis_storage_gdal_PJ_getEllipsoidDefinition
  (JNIEnv *, jobject);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    transform
 * Signature: (Lorg/apache/sis/storage/gdal/PJ;I[DII)V
 */
JNIEXPORT void JNICALL Java_org_apache_sis_storage_gdal_PJ_transform
  (JNIEnv *, jobject, jobject, jint, jdoubleArray, jint, jint);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    getLastError
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_org_apache_sis_storage_gdal_PJ_getLastError
  (JNIEnv *, jobject);

/*
 * Class:     org_apache_sis_storage_gdal_PJ
 * Method:    finalize
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_apache_sis_storage_gdal_PJ_finalize
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif