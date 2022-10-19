package com.atividadefinaldemodulobackend.exeception;

//CRIO UMA CLASSE PARA EXTENDER DE UM PAI, ESSE, SENDO UMA EXCEPTION - NO NOSSO CASO: RUNTIMEEXCEPTION
public class ExcecaoDePaginaNaoEncontrada extends RuntimeException{

    //NÓS CRIAMOS UM CONSTRUTOR PORQUE QUANDO CHAMARMOS ESSA EXCEPTION
    public ExcecaoDePaginaNaoEncontrada(String msg){
        super(msg);
    }
}
