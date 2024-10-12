package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();


        /*
            //CREAR FACTURA Y SETEAR LOS ATRIBUTOS
            Factura factura1 = new Factura();
            factura1.setNumero(12);
            factura1.setFecha("10/09/24");

            //CREAR DOMICILIO Y SE PASAN COMO ATRIBUTOS NOMBRECALLE Y NUMERO
            Domicilio dom = Domicilio.builder().nombreCalle("Las cañas").numero(1808).build();

            //CREAR CLIENTE Y SE SETEAN ATRIBUTOS
            Cliente cliente = Cliente.builder().nombre("Lisandro").apellido("Monclus").dni(44625831).build();
            cliente.setDomicilio(dom);
            dom.setCliente(cliente);

            //SETEAMOS A FACTURA EL CLIENTE
            factura1.setCliente(cliente);

            //CREAR CATEGORIAS
            Categoria liquidos = Categoria.builder().denominacion("Liquidos").build();
            Categoria gaseosa = Categoria.builder().denominacion("Gaseosa").build();
            Categoria comida = Categoria.builder().denominacion("Comida").build();

            //CREAR ARTICULOS
            Articulo articulo1 = Articulo.builder().cantidad(100).denominacion("Cocacola").precio(2000).build();
            Articulo articulo2 = Articulo.builder().cantidad(50).denominacion("Chocolate").precio(500).build();

            //SE ASIGNAN LOS ARTICULOS A LAS CATEGORIAS Y LAS CATEGORIAS A LOS ARTICULOS
            articulo1.getCategorias().add(liquidos);
            articulo1.getCategorias().add(gaseosa);
            liquidos.getArticulos().add(articulo1);
            gaseosa.getArticulos().add(articulo1);

            articulo2.getCategorias().add(comida);
            comida.getArticulos().add(articulo2);

            //detalle 1
            DetalleFactura detalle1 = DetalleFactura.builder().articulo(articulo1).cantidad(2).subtotal(4000).build();

            //BIRIDICCIONALIDADES detalle 1
            articulo1.getDetalle().add(detalle1);
            factura1.getDetalles().add(detalle1);
            detalle1.setFactura(factura1);

            //nuevo detalle
            DetalleFactura detalle2 = DetalleFactura.builder().articulo(articulo2).cantidad(1).subtotal(500).build();


            //BIRIDICCIONALIDADES detalle 2
            articulo2.getDetalle().add(detalle2);
            factura1.getDetalles().add(detalle2);
            detalle2.setFactura(factura1);

            //total de la factura
            factura1.setTotal(4500);

            */
            Factura factura1 = entityManager.find(Factura.class, 1L);
            //factura1.setNumero(85);


            entityManager.remove(factura1);

            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }



        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}