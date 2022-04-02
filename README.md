# Práctica 6. Testing de una aplicacion de Spring Boot

En esta práctica se han implementado una serie de tests para comprobar el correcto funcionamiento de las clases ``DNI``,``Telefono`` y `ProcessController`. Para las dos primeras, se han añadido ``Unit Tests`` y para la última, ``E2E Tests``. Para ello se ha creado el paquete `test` en el cuál se encuentran dos carpetas: ``controller`` y ``model``.

* ``DNITest`` es la clase encargada de realizar 3 tests, uno para corroborar que el DNI cumple con el formato adecuado, otro para los que no lo cumplen y el último que excluye los DNIs que no están permitidos por el Ministerio del Interior y son inválidos. <br> En cada test se han incluido numerosas casuísticas ya sea para probar distinitos DNIs válidos y para excluir aquellos que, por ejemplo, tienen más de una letra o son muy cortos.


* ``TelefonoTest`` realiza 2 test, uno para verificar los teléfonos correctos y que cumplen con las condiciones y, otro para no aceptar los teléfonos que no cumplen el formato. <br> De la misma forma, se incluyen varias casuísticas para comprobar numerosos de todo tipo (con guiones, puntos y prefijos internacionales) y no aceptar aquellos que no cumplen con la longitud requerida o tienen símbolos no aceptados.


* ``ProcessControllerE2ETest`` consta de 4 tests de los 2 endpoints presentes en su clase hómologa ``ProcessController``. En todos los tests se comprueba si los datos introducidos son correctos o no, pero en el ``PostMapping`` del proceso ``data-legacy`` se trabaja con ``MultiValueMap``y el mensaje que devuelve el resultado es ``message1`` o ``message2`` mientras que en el otro proceso se trabaja con ``DataRequest``y ``DataResponse`` y los mensajes devueltos son ``OK``o ``KO``. <br> No obstante, la estructura es siempre la misma, ya que dados unos datos, se obtiene el resultado y se evalúa si la respuesta es correcta. Para ello se ha comprobado que introduciendo datos correctos el mensaje es de éxito y con datos no válidos el mensaje devuelto es de error.
