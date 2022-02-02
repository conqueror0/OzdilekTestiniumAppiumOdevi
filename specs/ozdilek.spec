Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs


Ozdilekteyim
------------------------
*Mağazadan alışveriş alanını kontrol et
*Alısverise baslaya tıkla
*Anasayfada oldugunu kontrol et
*Kategoriye tıkla
*Kategorilerde oldugunu kontrol et
*Indexe gore tıkla
* xpath "//*[@text='Pantolon']" li elemente tıkla
* "5" saniye kadar bekle
*Sayfayı asagıya scroll et
*Sayfayı asagıya scroll et
* Elementler "//*[@resource-id='com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout" arasından rasgele bir tanesini seç ve tıkla
*4 saniye bekle
*Sayfayı asagıya scroll et
* xpath "//*[@text='Taksit Seçenekleri']" li elementi bul ve "Taksit Seçenekleri" alanını kontrol et
* 4 saniye bekle
* xpath "//*[@resource-id='com.ozdilek.ozdilekteyim:id/relLayFav']/android.widget.ImageView" li elemente tıkla
* 4 saniye bekle
* id "com.ozdilek.ozdilekteyim:id/btnLogin" li elementi bul ve "Giriş Yap" alanını kontrol et
* 4 saniye bekle
* id "com.ozdilek.ozdilekteyim:id/etEposta" li elemente tıkla
* id "com.ozdilek.ozdilekteyim:id/etEposta" li ementi bul ve "fatih" değerini yaz
* 4 saniye bekle
*id "com.ozdilek.ozdilekteyim:id/etPassword" li elemente tıkla
*id "com.ozdilek.ozdilekteyim:id/etPassword" li ementi bul ve "12345" değerini yaz
* 4 saniye bekle
*id "com.ozdilek.ozdilekteyim:id/ivBack" li elemente tıkla
* 4 saniye bekle
*id "com.ozdilek.ozdilekteyim:id/ivBack" li elemente tıkla
* 4 saniye bekle
* Elementler "//*[@resource-id='com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout" arasından rasgele bir tanesini seç ve tıkla
* 4 saniye bekle
* Elementler "//*[@resource-id='com.ozdilek.ozdilekteyim:id/tvInSizeItem']" arasından rasgele bir tanesini seç ve tıkla
* 4 saniye bekle
*id "com.ozdilek.ozdilekteyim:id/relLayAddCartBtn" li elemente tıkla
* 4 saniye bekle
