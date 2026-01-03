# Tu Gestion Amiga — Maquetación XML (SENA)

## 1. Descripción del proyecto
Este proyecto es una **maquetación (UI)** de mi aplicativo Tu Gestion Amiga, desarrollada en **Android Studio** usando **layouts XML** y **Material Design**.

El objetivo principal es **mostrar las pantallas y el flujo de navegación** (de forma sencilla) sin implementar backend, base de datos ni lógica de negocio real.

## 2. ¿Para qué sirve?
- Practicar la **creación de interfaces** en Android con `ConstraintLayout` y componentes Material.
- Tener un prototipo visual para validar el diseño antes de programar funcionalidades reales.
- Simular el flujo de mi software Tu Gestion Amiga si fuera una app: login, registro, menú, búsqueda, detalle y préstamos.

## 3. Pantallas maquetadas (XML)
Las maquetas se encuentran en: `app/src/main/res/layout/`

- `activity_login.xml` (Inicio de sesión)
- `activity_register.xml` (Registro)
- `activity_main.xml` (Menú principal + Bottom Navigation)
- `fragment_search.xml` (Buscar libros: buscador + chips + lista)
- `item_book.xml` (Tarjeta de libro)
- `activity_book_detail.xml` (Detalle del libro)
- `activity_loans.xml` (Mis préstamos: Activos/Historial + lista)
- `item_loan.xml` (Tarjeta de préstamo)
- `activity_account.xml` (Mi cuenta)
- `activity_help.xml` (Ayuda)

## 4. Navegación (sencilla)
Aunque el enfoque es maquetación, se agregó una navegación básica para poder **probar las pantallas**:

- **LoginActivity** (pantalla inicial)
  - `Iniciar sesión` → Menú principal
  - `Registrarse` → Registro
- **RegisterActivity**
  - Botón back → vuelve
  - `Crear cuenta` → Menú principal
- **MainActivity (Menú)**
  - Botones del menú y `BottomNavigationView` → abren pantallas de buscar, préstamos, cuenta y ayuda.
- **SearchActivity**
  - Muestra una lista de libros de ejemplo.
  - `Ver Detalle` → abre el detalle del libro.
- **LoansActivity**
  - Muestra préstamos de ejemplo.
  - Selector **Activos/Historial** cambia la lista.

> Nota: La navegación se hizo con **Intents** y datos “mock” (de ejemplo) únicamente para visualizar.

## 5. Estructura del proyecto
- **Layouts XML:** `app/src/main/res/layout/`
- **Recursos (colores, textos, tema):** `app/src/main/res/values/`
- **Íconos/drawables:** `app/src/main/res/drawable/`
- **Menú BottomNavigation:** `app/src/main/res/menu/bottom_nav_menu.xml`
- **Código Kotlin (Activities y adapters):** `app/src/main/java/com/example/tugestionamiga/`

## 6. ¿Cómo ejecutarlo en Android Studio?
1. Abrir Android Studio.
2. `File > Open` y seleccionar la carpeta del proyecto: `MaquetadoMovil`.
3. Esperar a que Gradle haga `Sync` (si te lo pide, aceptar).
4. Conectar un celular con **Depuración USB** o crear un emulador:
   - `Tools > Device Manager` → Crear/usar un emulador.
5. Presionar **Run (▶)**.

### Recomendación (si hay error con el JDK)
Android/Gradle normalmente trabajan mejor con **JDK 17 o 21**. Si tu PC tiene JDK 25 instalado, en Android Studio configura:
- `Settings > Build, Execution, Deployment > Gradle > Gradle JDK` y selecciona JDK 17/21.

## 7. Consideraciones
- Este proyecto es **prototipo visual**, no tiene autenticación real ni consultas a servidor.
- Los listados (`RecyclerView`) usan datos de ejemplo para mostrar cómo se vería la app.


