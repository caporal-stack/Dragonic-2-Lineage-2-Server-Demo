# 🌍 Dragonic 2 – L2J High Five Server (Demo Pack)

Custom Lineage II HF server source with Community Board auctions, ranking, and dress/undress system.

<img src="https://github.com/caporal-stack/Dragonic-2-Lineage-2-Server-Demo/blob/main/images/COMMUNITY%20BOARD.jpg" width="50%" height="300">

---

## ⚙️ Requirements

- JDK 1.8+
- MySQL 5.6+
- Maven or Gradle
- Git LFS (for large assets)

---

## 🚀 Setup Instructions

1. **Import SQL schema**
   - Use the files in `/sql/` to create your database.
2. **Configure properties**
   - Copy `.example` files to `.properties` and fill in DB credentials.
3. **Build the project**
   ```bash
   mvn clean install
