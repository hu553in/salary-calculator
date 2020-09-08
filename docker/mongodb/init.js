db.createUser({
    user: 'employees_admin',
    pwd: 'employees_password',
    roles: [{
        role: 'readWrite',
        db: 'employees',
    }],
});
