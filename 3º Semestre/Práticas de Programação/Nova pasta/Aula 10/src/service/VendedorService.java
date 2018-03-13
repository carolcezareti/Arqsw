package service;

import java.util.ArrayList;
import model.Pais;
import dao.PaisDAO;

public class VendedorService {
PaisDAO dao;
public VendedorService(){
dao = new PaisDAO();
}
public ArrayList<Pais> listarPaises(){
return dao.listarPais();
}
public ArrayList<Pais> listarPaises(String chave){
return dao.listarPais();
}
}
