package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TelefonoTest {

    @Test
    public void Telefono_correcto(){
        // Teléfonos que cumplen con el formato establecido
        Telefono tlf = new Telefono("2055550125");
        assertEquals(true,tlf.validar());

        Telefono tlf2 = new Telefono("202-555-0125");
        assertEquals(true,tlf2.validar());

        Telefono tlf3 = new Telefono("(202) 555-0125");
        assertEquals(true,tlf3.validar());

        Telefono tlf4 = new Telefono("636.856.7890");
        assertEquals(true,tlf4.validar());

        Telefono tlf5 = new Telefono("636 856 789");
        assertEquals(true,tlf5.validar());

        Telefono tlf6 = new Telefono("636 85 67 89");
        assertEquals(true,tlf6.validar());

        Telefono tlf7 = new Telefono("+34636856789");
        assertEquals(true,tlf7.validar());

        Telefono tlf8 = new Telefono("+34 636856789");
        assertEquals(true,tlf8.validar());

        Telefono tlf9 = new Telefono("+34 636 85 67 89");
        assertEquals(true,tlf9.validar());

        Telefono tlf10 = new Telefono("+45 (202) 555-0125");
        assertEquals(true,tlf10.validar());
    }

    @Test
    public void Telefono_incorrecto(){
        // Teléfonos que no cumplen con el formato establecido
        Telefono tlf_incorrecto = new Telefono("654");
        assertEquals(false,tlf_incorrecto.validar());

        Telefono tlf_incorrecto2 = new Telefono("65430456");
        assertEquals(false,tlf_incorrecto2.validar());

        Telefono tlf_incorrecto3 = new Telefono("202^555-012");
        assertEquals(false,tlf_incorrecto3.validar());

        Telefono tlf_incorrecto4 = new Telefono("202555-012");
        assertEquals(false,tlf_incorrecto4.validar());

        Telefono tlf_incorrecto5 = new Telefono("+900091 654");
        assertEquals(false,tlf_incorrecto5.validar());

        Telefono tlf_incorrecto6 = new Telefono("+9007281011091654");
        assertEquals(false,tlf_incorrecto6.validar());

        Telefono tlf_incorrecto7 = new Telefono("56782920374946");
        assertEquals(false,tlf_incorrecto7.validar());

        Telefono tlf_incorrecto8 = new Telefono("1.5.6.1");
        assertEquals(false,tlf_incorrecto8.validar());
    }
}