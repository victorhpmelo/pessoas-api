package br.embarquedigital.universidadesapi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message + " Não Existe");
    }
}
