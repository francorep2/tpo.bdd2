*Comandos de GIT*

Clonar el repositorio:
git clone <url-https-del-repo>

Esto trae el repositorio a tu máquina local.

Crear y cambiar a una nueva rama (antes de hacer cambios):
git checkout -b <nombre-rama>

Esto crea una nueva rama y te cambia a esa rama.

Subir la nueva rama al repositorio remoto (si no tienes commits aún, este paso puede ser opcional):
git push -u origin <nombre-rama>

Esto sube la rama al repositorio remoto y establece una relación de seguimiento entre tu rama local y la remota.

Agregar cambios a la rama:
git add .

Esto agrega todos los cambios que has hecho en tu directorio de trabajo al área de preparación.

Crear un commit:
git commit -m "<escribir-un-mensaje>"

Esto crea un commit con un mensaje descriptivo.

Pushear los cambios a la rama:
git push origin <nombre-rama>

Esto sube tus commits a la rama remota. No es necesario el -u aquí si ya has hecho el push inicial.


test!



