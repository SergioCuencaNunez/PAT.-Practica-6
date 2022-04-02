package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DNITest {

    @Test
    public void DNI_correcto(){
        // DNIs que cumplen con el formato establecido
        DNI dni = new DNI("45132222N");
        assertEquals(true,dni.validar());

        DNI dni2 = new DNI("67458354K");
        assertEquals(true,dni2.validar());

        DNI dni3 = new DNI("41533165H");
        assertEquals(true,dni3.validar());

        DNI dni4 = new DNI("27617194J");
        assertEquals(true,dni4.validar());

        DNI dni5 = new DNI("90639938C");
        assertEquals(true,dni5.validar());

        DNI dni6 = new DNI("59801665D");
        assertEquals(true,dni6.validar());

        DNI dni7 = new DNI("64840734P");
        assertEquals(true,dni7.validar());

        DNI dni8 = new DNI("26584681Q");
        assertEquals(true,dni8.validar());
    }

    @Test
    public void DNI_incorrecto(){
        // DNIs que no cumplen con el formato establecido
        DNI dni_incorrecto = new DNI("123456789");
        assertEquals(false,dni_incorrecto.validar());

        DNI dni_incorrecto2 = new DNI("1234");
        assertEquals(false,dni_incorrecto2.validar());

        DNI dni_incorrecto3 = new DNI("1234567890");
        assertEquals(false,dni_incorrecto3.validar());

        DNI dni_incorrecto4 = new DNI("ABCDEFGHIJ");
        assertEquals(false,dni_incorrecto4.validar());

        DNI dni_incorrecto5 = new DNI("ABCDEFGHI");
        assertEquals(false,dni_incorrecto5.validar());

        DNI dni_incorrecto6 = new DNI("ABCD");
        assertEquals(false,dni_incorrecto6.validar());

        DNI dni_incorrecto7 = new DNI("123456789A");
        assertEquals(false,dni_incorrecto7.validar());

        DNI dni_incorrecto8 = new DNI("1234D");
        assertEquals(false,dni_incorrecto8.validar());

        DNI dni_incorrecto9 = new DNI("8763924PE");
        assertEquals(false,dni_incorrecto9.validar());

        DNI dni_incorrecto10 = new DNI("749GR7820");
        assertEquals(false,dni_incorrecto10.validar());
    }

    @Test
    public void DNI_invalido(){
        // DNIs que no son válidos aunque cumplen con el formato establecido
        DNI dni_invalido = new DNI("00000000T");
        assertEquals(false,dni_invalido.validar());

        DNI dni_invalido2 = new DNI("00000001R");
        assertEquals(false,dni_invalido2.validar());

        DNI dni_invalido3 = new DNI("99999999R");
        assertEquals(false,dni_invalido3.validar());
    }
}
