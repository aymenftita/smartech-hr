export class Employee {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    hireDate: Date;
    jobTitle: string;
    HasSupervisor: boolean;
    role: RoleType;
    
    constructor(
        id: number,
        firstName: string,
        lastName: string,
        email: string,
        phoneNumber: string,
        hireDate: Date,
        jobTitle: string,
        HasSupervisor: boolean,
        role: RoleType
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobTitle = jobTitle;
        this.HasSupervisor = HasSupervisor;
        this.role = role;
    }
}

enum RoleType {
    ADMIN = 'admin',
    EMPLOYEE = 'employee',
    MANAGER = 'manager',
    HR = 'hr'
}