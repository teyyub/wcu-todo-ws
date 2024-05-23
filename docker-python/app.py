# app.py
import sqlite3

# Connect to SQLite database (creates if not exists)
conn = sqlite3.connect('example.db')

# Create a cursor object to execute SQL commands
cursor = conn.cursor()

# Create a table if not exists
cursor.execute('''CREATE TABLE IF NOT EXISTS users
                  (id INTEGER PRIMARY KEY, name TEXT, email TEXT)''')

# Insert some data
cursor.execute("INSERT INTO users (name, email) VALUES (?, ?)", ('John Doe', 'john@example.com'))
cursor.execute("INSERT INTO users (name, email) VALUES (?, ?)", ('Jane Doe', 'jane@example.com'))

# Commit changes
conn.commit()

# Fetch all records
cursor.execute("SELECT * FROM users")
rows = cursor.fetchall()
for row in rows:
    print(row)

# Close connection
conn.close()
