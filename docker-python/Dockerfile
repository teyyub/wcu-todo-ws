# Dockerfile
FROM python:3.9-alpine

# Install SQLite3 and dependencies
RUN apk add --no-cache sqlite

# Set working directory
WORKDIR /app

# Copy Python script into container
COPY app.py .

# Run the Python script
CMD ["python", "app.py"]
