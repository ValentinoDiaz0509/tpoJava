
## 📄 `README.txt` – Sistema de Gestión de Garage Privado (Java + Swing)

### 👨‍💻 Autor:

Materia: Paradigma Orientado a Objetos
Trabajo Práctico: Garage Privado
Lenguaje: Java
Interfaz gráfica: Swing

---

### 🛠️ Requisitos del sistema

* Java JDK 8 o superior
* IDE como IntelliJ IDEA, Eclipse o NetBeans
* Todas las clases en el mismo paquete 

---

### 🗂️ Archivos generados

Al utilizar el sistema, se generan automáticamente los siguientes archivos en la carpeta raíz del proyecto:

* `clientes.txt`: Lista de clientes registrados
* `tickets.txt`: Lista de tickets generados
* `pagos.txt`: Pagos registrados
* (Opcional) `plazas.txt`: si se implementa persistencia del estado de las plazas

---

### ▶️ Cómo ejecutar el sistema

1. Asegurate de tener todas las clases dentro del paquete `Clases`.
2. Abrí el archivo `GarageUI.java` y ejecutá su método `main`.
3. Se abrirá una ventana con la interfaz gráfica del sistema.

---

### ✅ Funcionalidades disponibles

#### 📥 Registrar Entrada de Cliente

* Ingresar nombre, teléfono, marca, patente, tipo de vehículo, monto y método de pago.
* El sistema:

  * Asigna automáticamente una plaza libre.
  * Genera ticket de ingreso.
  * Registra y guarda el pago.
  * Muestra el número de plaza asignada.
  * Guarda automáticamente la información.

#### 📤 Registrar Salida

* Ingresar número de plaza ocupada.
* El sistema libera la plaza correspondiente.

#### 📃 Listar Información

* Botón "Listar Clientes": muestra todos los clientes registrados.
* Botón "Listar Tickets": muestra todos los tickets generados.
* Botón "Estado de Plazas": muestra plazas libres y ocupadas.

#### 📊 Informe del Gerente

* Muestra informe financiero detallado (pagos registrados).
* Lista todos los empleados del sistema ordenados por DNI.

---

### 💾 Persistencia

Todos los datos ingresados se guardan automáticamente en archivos `.txt` al realizar una acción (entrada, salida, pago).
Esto permite mantener los registros incluso si se cierra el programa.

---

### 🧪 Ejemplo de uso

1. Ingresá los datos de un cliente y su vehículo.

2. Seleccioná método de pago y monto.

3. Presioná "Registrar Entrada".

4. El sistema mostrará:
   `Cliente Juan Pérez ingresado. Pago: $5000 (efectivo)`
   `Cliente registrado: Juan Pérez en plaza 15`

5. Para liberar la plaza: ingresar el número en el campo correspondiente y presionar "Registrar Salida".

---

### 📌 Notas adicionales

* En caso de ingresar una patente ya existente, el sistema mostrará un mensaje de error.
* Si no hay plazas disponibles, se notificará al usuario.

---

