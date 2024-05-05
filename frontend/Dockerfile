FROM node:14-alpine as build

WORKDIR /app

# Copy only the necessary files for installing dependencies
COPY package.json package-lock.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Build the application
RUN npm run build

# Stage 2: Production environment
FROM nginx:alpine

# Copy build output from the previous stage
COPY --from=build /app/build /usr/share/nginx/html

# Expose ports to the outside world

EXPOSE 3000
EXPOSE 4000

# Default command to start nginx
CMD ["nginx", "-g", "daemon off;"]
