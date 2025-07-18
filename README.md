# 🍬 Sweet Shop Management System — TDD Kata

This project is a **Test-Driven Development (TDD)** kata solution for the **Incubyte recruitment process**.  
It models a simple Sweet Shop with full CRUD operations and flexible search functionality.

---

## - Features Implemented

### - Core Operations
- **Add Sweet**: Add new sweet items to the inventory.
- **Delete Sweet**: Remove a sweet by ID.
- **View Sweets**: See all sweets in the inventory.
- **Purchase Sweet**: Buy sweets, automatically updates stock.
  - Throws `OutOfStockException` if there is not enough stock.
- **Restock Sweet**: Add stock to existing sweets.
  - Throws `IllegalArgumentException` if sweet ID is invalid.

