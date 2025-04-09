# Refactorización del Método `getScore` en Java

Este proyecto incluye una versión refactorizada del método `getScore`, que calcula el marcador en un partido de tenis. La refactorización se ha realizado para mejorar la **claridad, legibilidad y mantenibilidad** del código.

---

## 🛠️ Cambios Realizados

### 1. Eliminación de la variable compartida `score`
En el código original, se utilizaba una única variable `score` para construir el resultado, la cual era modificada en distintos bloques condicionales. Esto dificultaba la lectura y el uso de herramientas como `Extract Method` en IntelliJ IDEA.

**Solución aplicada:**  
Cada bloque condicional ahora **devuelve directamente** el `String` con la puntuación, eliminando así la necesidad de una variable externa.

---

### 2. Extracción de métodos independientes

Se han extraído tres métodos nuevos desde el método principal `getScore()`:

#### `getEqualScore(int score)`
- Se encarga de devolver el resultado cuando ambos jugadores tienen el mismo puntaje.
- Usa `switch` para determinar el texto apropiado (`Love-All`, `Fifteen-All`, etc.).

#### `getAdvantageOrWin(int m_score1, int m_score2)`
- Calcula si uno de los jugadores tiene ventaja o ha ganado, siempre que alguno haya llegado a 4 o más puntos.
- Devuelve cadenas como `Advantage player1` o `Win for player2`.

#### `getStandardScore(int m_score1, int m_score2)`
- Se usa cuando no hay empate ni ventaja.
- Usa un bucle y un `switch` para armar el resultado como `Thirty-Fifteen`, `Love-Forty`, etc.

---

## ✅ Ventajas de la Refactorización

- ✅ **Legibilidad mejorada**: El método principal se entiende de un vistazo.
- ✅ **Mantenibilidad**: Cada regla del tenis está encapsulada en su propio método.
- ✅ **Reutilización y pruebas**: Los métodos separados permiten realizar pruebas unitarias más fáciles.
- ✅ **Compatibilidad con IntelliJ**: Ahora se puede usar `Extract Method` sin restricciones.

---

## 📄 Código Original vs Refactorizado

**Antes:**
```java
String score = "";
// ...múltiples bloques que modifican score...
return score;