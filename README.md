# CarteleraVirtual
Este proyecto alcanzo la etapa de asegurar un Spring Core y API RESTful del cual se consumen los datos necesarios para la sigueinte etapa que era realizar un fronted con Angular, el cual deberia ser deployado en algun servidor.

# Perfiles de Usuario
## Perfil Administrador
Los usuarios de este perfil deben poder:
- Crear, modificar y dar de baja carteleras.
- Crear, modificar y dar de baja publicaciones en cualquiera de las carteleras.
- Administración de permisos de usuarios sobre las carteleras: por ejemplo un profesor debería poder
publicar en carteleras de años donde dicta sus asignaturas, un secretario (con perfil de publicador)
debería poder publicar en carteleras institucionales, etc.
- Crear, modificar y dar de baja publicadores y administradores.

## Perfil Docente
Los usuarios de este perfil deben poder:
- Loguearse al sistema mediante su usuario y clave de Guaraní.
- Visualizar todas las carteleras dándole prioridad a las carteleras de las materias en las que puede
publicar.
- Crear, modificar y dar de baja publicaciones en cualquiera de las carteleras en las que tenga
permisos.
- Habilitar/deshabilitar comentarios de las publicaciones que publica.
- Ver la lista de alumnos que están interesados en las cartelera que el docente tiene permiso de
publicación.

## Perfil Alumno
Los usuarios de este perfil deben poder:
- Loguearse al sistema mediante su usuario y clave de Guaraní.
- Visualizar todas las carteleras dándole prioridad a las carteleras de las que registró interés.
- Registrar interés en una cartelera para recibir notificaciones cuando se actualice. Analizar
posibilidades de notificación: email, facebook, etc. y permitir que el alumno elija la forma.
- Comentan publicaciones de las carteleras.

## Publicadores
- Son usuarios que no cumplen con los perfiles anteriores pero están habilitados para publicar en
alguna cartelera. Por ejemplo una empresa o institución que busca Recursos Humanos.
- Visualizar todas las carteleras

# Contenido de las Publicaciones
- Las carteleras son públicas, de esta manera no es necesario otorgar permisos de lectura.
- Las publicaciones deben incluir un título y un contenido en formato texto, pero además analice otros
tipo de datos imágenes, enlaces, videos, etc.


# Sobre la Interfaz de Usuario
Se espera que la Interfaz de Usuario sea intuitiva, amigable, de rápido acceso a la información.
Al diseñar el tamaño y la disposición de las componentes, tenga en cuenta:
- La forma en que se mostrarán las carteleras y los carteles que incluye. La cantidad de carteleras es
dinámica.
- La ubicación y tamaño de los carteles dentro de una cartelera. La cantidad de carteles es dinámica.
- El diseño del sitio deberá ser atractivo para los visitantes
- La página home debe incluir las carteleras.
Agregue todas las funcionalidades y características que le gustaría que tenga su cartelera
actualmente.
