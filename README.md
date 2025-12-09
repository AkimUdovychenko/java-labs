# Java Labs (7 labs)

Repo structure:
```
java-labs/
└── labs/
    ├── lab1/
    │   └── src/main/java/lab1/  # code for lab1
    ├── lab2/
    ├── lab3/
    ├── lab4/
    ├── lab5/
    ├── lab6/
    └── lab7/
```
Each lab is a tiny standalone Java console program set (no build tool needed).  
Compile & run Lab 1 from the repo root:

**Windows (PowerShell or cmd):**
```bat
cd labs\lab1\src\main\java
javac lab1\*.java
java lab1.Lab1Menu
```

**macOS/Linux:**
```bash
cd labs/lab1/src/main/java
javac lab1/*.java
java lab1.Lab1Menu
```

You can copy the same pattern for other labs.

## Git quick start
```bash
git init
git add .
git commit -m "Lab1: initial commit"
git branch -M main
git remote add origin https://github.com/<your-username>/java-labs.git
git push -u origin main
```
