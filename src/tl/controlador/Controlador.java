package tl.controlador;

import UI.UI;
import bl.entidades.Administrativo;
import bl.entidades.Audio;
import bl.entidades.Estudiante;
import bl.entidades.Material;
import bl.entidades.Otro;
import bl.entidades.Prestamo;
import bl.entidades.Profesor;
import bl.entidades.Texto;
import bl.entidades.Usuario;
import bl.entidades.Video;
import bl.gestor.Gestor;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controlador {

    private UI ui = new UI();
    private Gestor gestor = new Gestor();

    public void ejecutar() {

        boolean ward = true;
        int action = 0;
        while (ward) {
            switch (action) {
                case 0:
                    action = ui.menu(true);
                    break;
                case 1:
                    registrarUsuario();
                    action = 0;
                    break;
                case 2:
                    listarUsuarios();
                    action = 0;
                    break;
                case 3:
                    registrarMaterial();
                    action = 0;
                    break;
                case 4:
                    listarMateriales();
                    action = 0;
                    break;
                case 5:
                    realizarPrestamo();
                    action = 0;
                    break;
                case 6:
                    realizarDevolucion();
                    action = 0;
                    break;
                case 7:
                    gestor.listarPrestamos(false);
                    action = 0;
                    break;
                case 8:
                    System.out.println("Adiós!");
                    ward = false;
                    break;
                case -1:
                    action = ui.menu(false);
                default:

            }
        }

    }

    private void registrarUsuario() {
        ui.imprimir("\nRegistrar Usuario"
                + "\nPresione 1 para registrar un Estudiante"
                + "\nPresione 2 para registrar un Profesor"
                + "\nPresione 3 para registrar un Administrativo"
                + "\nPresione cualquier otra tecla para cancelar");
        switch (ui.readInt()) {
            case 1:
                ui.imprimir("\nIngrese el nombre del estudiante:");
                String nombreEstudiante = ui.readString();
                ui.imprimir("\nIngrese los apellidos del estudiante:");
                String apellidosEstudiante = ui.readString();
                ui.imprimir("\nIngrese el ID del estudiante:");
                String idEstudiante = ui.readString();
                ui.imprimir("\nIngrese la carrera del estudiante:");
                String carreraEstudiante = ui.readString();
                ui.imprimir("\nIngrese la cantidad de creditos actuales del estudiante:");
                int creditosEstudiante = ui.readInt();
                Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, apellidosEstudiante, idEstudiante, carreraEstudiante, creditosEstudiante);
                gestor.agregarUsuario(nuevoEstudiante);
                break;
            case 2:
                ui.imprimir("\nIngrese el nombre del Profesor:");
                String nombreProfesor = ui.readString();
                ui.imprimir("\nIngrese los apellidos del Profesor:");
                String apellidosProfesor = ui.readString();
                ui.imprimir("\nIngrese el ID del Profesor:");
                String idProfesor = ui.readString();
                ui.imprimir("\nIngrese el tipo de contrato del profesor:");
                String contratoProfesor = ui.readString();
                ui.imprimir("\nIngrese la fecha de contratacion del profesor:");
                String fechaProfesor = ui.readString();
                Profesor nuevoProfesor = new Profesor(nombreProfesor, apellidosProfesor, idProfesor, contratoProfesor, LocalDate.parse(fechaProfesor));
                gestor.agregarUsuario(nuevoProfesor);
                break;
            case 3:
                ui.imprimir("\nIngrese el nombre del Administrativo:");
                String nombreAdministrativo = ui.readString();
                ui.imprimir("\nIngrese los apellidos del Administrativo:");
                String apellidosAdministrativo = ui.readString();
                ui.imprimir("\nIngrese el ID del Administrativo:");
                String idAdministrativo = ui.readString();
                ui.imprimir("\nIngrese el tipo de nombramiento del Administrativo:");
                String nombramientoAdministrativo = ui.readString();
                ui.imprimir("\nIngrese las horas semanales del Administrativo:");
                double horasSemanales = ui.readDouble();
                Administrativo nuevoAdministrativo = new Administrativo(nombramientoAdministrativo, horasSemanales, nombreAdministrativo, apellidosAdministrativo, idAdministrativo);
                gestor.agregarUsuario(nuevoAdministrativo);
                break;
            default:
                break;
        }
    }

    private void registrarMaterial() {
        ui.imprimir("\nRegistrar Material"
                + "\nPresione 1 para registrar un Texto"
                + "\nPresione 2 para registrar un Audio"
                + "\nPresione 3 para registrar un Video"
                + "\nPresione 4 para registrar Otro"
                + "\nPresione cualquier otra tecla para cancelar");
        switch (ui.readInt()) {
            case 1:
                ui.imprimir("\nIngrese la signatura del Texto:");
                String signaturaTexto = ui.readString();
                ui.imprimir("\nIngrese el titulo del Texto:");
                String tituloTexto = ui.readString();
                ui.imprimir("\nIngrese el tema del texto:");
                String temaTexto = ui.readString();
                ui.imprimir("\nIngrese el idioma del texto: (Opcional)");
                String idiomaTexto = ui.readString();
                ui.imprimir("\nIngrese el nombre del autor del Texto:");
                String autorTexto = ui.readString();
                ui.imprimir("\nIngrese la fecha de publicacion del texto:");
                String fechaPublicacionTexto = ui.readString();
                ui.imprimir("\nIngrese el numero de paginas del texto:");
                String paginasTexto = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del texto:");
                String fechaCompraTexto = ui.readString();
                ui.imprimir("\nEl texto está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnTexto = ui.readString();
                boolean restringidoTexto;
                if (restringidoLnTexto.toLowerCase().equals("si")) {
                    restringidoTexto = true;
                } else {
                    restringidoTexto = false;
                }

                Texto nuevoTexto = new Texto(tituloTexto, autorTexto, LocalDate.parse(fechaPublicacionTexto), Integer.parseInt(paginasTexto), signaturaTexto, LocalDate.parse(fechaCompraTexto), restringidoTexto, temaTexto, idiomaTexto);
                gestor.agregarMaterial(nuevoTexto);
                break;

            case 2:
                ui.imprimir("\nIngrese la signatura del Audio:");
                String signaturaAudio = ui.readString();
                ui.imprimir("\nIngrese la duracion del Audio:");
                String duracionAudio = ui.readString();
                ui.imprimir("\nIngrese el idioma del Audio: (Opcional)");
                String idiomaAudio = ui.readString();
                ui.imprimir("\nIngrese el formato del Audio:");
                String formatoAudio = ui.readString();
                ui.imprimir("\nIngrese el tema del Audio:");
                String temaAudio = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del Audio:");
                String fechaCompraAudio = ui.readString();
                ui.imprimir("\nEl Audio está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnAudio = ui.readString();
                boolean restringidoAudio;
                if (restringidoLnAudio.toLowerCase().equals("si")) {
                    restringidoAudio = true;
                } else {
                    restringidoAudio = false;
                }

                Audio nuevoAudio = new Audio(formatoAudio, duracionAudio, idiomaAudio, signaturaAudio, LocalDate.parse(fechaCompraAudio), restringidoAudio, temaAudio);
                gestor.agregarMaterial(nuevoAudio);
                break;
            case 3:
                ui.imprimir("\nIngrese la signatura del Video:");
                String signaturaVideo = ui.readString();
                ui.imprimir("\nIngrese la duracion del Video:");
                String duracionVideo = ui.readString();
                ui.imprimir("\nIngrese el director del Video:");
                String directorVideo = ui.readString();
                ui.imprimir("\nIngrese el idioma del Video: (Opcional)");
                String idiomaVideo = ui.readString();
                ui.imprimir("\nIngrese el formato del Video:");
                String formatoVideo = ui.readString();
                ui.imprimir("\nIngrese el tema del Video:");
                String temaVideo = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del Video:");
                String fechaCompraVideo = ui.readString();
                ui.imprimir("\nEl Video está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnVideo = ui.readString();
                boolean restringidoVideo;
                if (restringidoLnVideo.toLowerCase().equals("si")) {
                    restringidoVideo = true;
                } else {
                    restringidoVideo = false;
                }

                Video nuevoVideo = new Video(formatoVideo, duracionVideo, idiomaVideo, directorVideo, signaturaVideo, LocalDate.parse(fechaCompraVideo), restringidoVideo, temaVideo);
                gestor.agregarMaterial(nuevoVideo);
                break;
            case 4:
                ui.imprimir("\nIngrese la signatura del Material:");
                String signaturaOtro = ui.readString();
                ui.imprimir("\nIngrese la descripcion del Material:");
                String descripcionOtro = ui.readString();
                ui.imprimir("\nIngrese el tema del Material:");
                String temaOtro = ui.readString();
                ui.imprimir("\nIngrese la fecha de Compra del Material:");
                String fechaCompraOtro = ui.readString();
                ui.imprimir("\nEl Material está restringido? Responda Si o cualquier otra cosa para No");
                String restringidoLnOtro = ui.readString();
                boolean restringidoOtro;
                if (restringidoLnOtro.toLowerCase().equals("si")) {
                    restringidoOtro = true;
                } else {
                    restringidoOtro = false;
                }

                Otro nuevoOtro = new Otro(descripcionOtro, signaturaOtro, LocalDate.parse(fechaCompraOtro), restringidoOtro, temaOtro);
                gestor.agregarMaterial(nuevoOtro);
                break;

            default:
                break;
        }
    }

    private void realizarPrestamo() {

        gestor.listarUsuarios();
        ui.imprimir("\n\n***Ingrese el ID del usuario a realizar el **\n");
        boolean checkEstudiante = true;
        Usuario estudiante = null;
        String ID = "0";
        while (checkEstudiante) {
            ID = ui.readString();
            estudiante = gestor.obtenerUsuario(ID);
            if (estudiante != null) {
                checkEstudiante = false;
            } else {
                ui.imprimir("\nID inválido, intente de nuevo.");
            }
        }
        ArrayList<Material> adding = new ArrayList<>();
        gestor.listarMateriales();
        boolean add = true;
        while (add) {
            ui.imprimir("Ingrese la signatura del material a prestar");
            boolean checkMaterial = true;
            Material material;
            while (checkMaterial) {
                material = gestor.obtenerMaterial(ui.readString());
                adding.add(material);
                if (material != null) {
                    checkMaterial = false;
                } else {
                    ui.imprimir("\nSignatura inválida, intente de nuevo.");
                }
            }
            ui.imprimir("Si desea agregar otro material presione 1, sino presione cualquier tecla");
            //if (ui.readInt() != 1) {
            add = false;
            //}
        }
        ui.imprimir("Ingrese la fecha de devolucion:");
        LocalDate devolucion = null;
        boolean checkFecha = true;
        while (checkFecha) {
            try {
                devolucion = LocalDate.parse(ui.readString());
                checkFecha = false;
            } catch (Exception ex) {
                ui.imprimir("Fecha invalida. Intente de nuevo");
            }
        }
        ui.imprimir("Ingrese el monto del prestamo:");
        double monto = ui.readDouble();
        boolean checkMonto = true;
        while (checkMonto) {
            int x = 500;
            if (x >= 0) {
                monto = x;
                checkMonto = false;
            } else {
                ui.imprimir("Monto invalido.");
            }
        }
        ui.imprimir("Ingrese el monto de la multa:");
        double montoMulta = ui.readDouble();
        boolean checkMulta = true;
        while (checkMulta) {
            int y = 50;
            if (y >= 0) {
                montoMulta = y;
                checkMulta = false;
            } else {
                ui.imprimir("Monto invalido.");
            }
        }
        String prestamoID = gestor.getNewPrestamoID();
        Prestamo nuevoPrestamo = new Prestamo(prestamoID, estudiante, devolucion, montoMulta, monto);
        nuevoPrestamo.setMateriales(adding);
        estudiante.addPrestamo(nuevoPrestamo);
        gestor.updateUsuario(ID, estudiante);
        gestor.agregarPrestamo(nuevoPrestamo);

    }

    private void realizarDevolucion() {

        if (gestor.listarPrestamos(true)) {
            ui.imprimir("Seleccione el ID del prestamo");
            String ID = ui.readString();
            Prestamo prestamo = gestor.obtenerPrestamo(ID);
            ui.imprimir("Si desea ingresar la fecha a registrar en la devolucion ingresela ahora \nDe lo contrario digite cualquier cosa para usar la fecha de hoy");
            LocalDate fecha = LocalDate.now();
            try {
                fecha = LocalDate.parse(ui.readString());
            } catch (Exception ex) {

            }
            Usuario update = gestor.devolverPrestamo(prestamo, fecha);

            System.out.println(update.toCSVLine());
            ArrayList<Prestamo> lista = update.getPrestamos();
            int index = -1;
            for (int i = 0; i < lista.size(); i++) {
                if (prestamo.getID().equals(lista.get(i).getID())) {
                    index = i;
                }
            }
            lista.set(index, prestamo);
            update.setPrestamos(lista);
            System.out.println(update.toCSVLine());
            gestor.updateUsuario(update.getID(), update);
            gestor.updatePrestamo(ID, prestamo);
        } else {
            ui.imprimir("No hay prestamos a devolver!");
        }

    }

    private void listarUsuarios() {
        ui.imprimir("\nEliga el tipo de usuario que desea listar:"
                + "\nPresione 1 para listar los estudiantes"
                + "\nPresione 2 para listar los profesores"
                + "\nPresione 3 para listar los administrativos"
                + "\nPresione 4 para listar todos\n");
        boolean ward = true;
        while (ward) {
            switch (ui.readInt()) {
                case 1:
                    gestor.listarEstudiantes(true);
                    ward = false;
                    break;
                case 2:
                    gestor.listarProfesores();
                    ward = false;
                    break;
                case 3:
                    gestor.listarAdministrativos();
                    ward = false;
                    break;
                case 4:
                    gestor.listarUsuarios();
                    ward = false;
                    break;
                default:
                    ui.imprimir("\nOpción inválida. Intente de nuevo.\n");
            }
        }

    }

    private void listarMateriales() {
        ui.imprimir("\nEliga el tipo de material que desea listar:"
                + "\nPresione 1 para listar los Textos"
                + "\nPresione 2 para listar los Audios"
                + "\nPresione 3 para listar los Videos"
                + "\nPresione 4 para listar los Otros"
                + "\nPresione 5 para listar todos\n");
        boolean ward = true;
        while (ward) {
            switch (ui.readInt()) {
                case 1:
                    gestor.listarTextos();
                    ward = false;
                    break;
                case 2:
                    gestor.listarAudios();
                    ward = false;
                    break;
                case 3:
                    gestor.listarVideos();
                    ward = false;
                    break;
                case 4:
                    gestor.listarOtros();
                    ward = false;
                    break;
                case 5:
                    gestor.listarMateriales();
                    ward = false;
                    break;
                default:
                    ui.imprimir("\nOpción inválida. Intente de nuevo.\n");
            }
        }
    }

}
