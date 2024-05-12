package com.Allura.LiterAlura.service;

public interface IConversion {
    <T> T obtenerDatos(String json, Class<T> clase);
}
