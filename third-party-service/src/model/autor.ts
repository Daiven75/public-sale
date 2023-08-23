export class Author {
    
    private readonly name: string;
    private readonly email: string;

    constructor() {
        this.name = this.generateName();
        this.email = this.generateEmail();
    }

    getName(): string {
        return this.name;
    }

    getEmail(): string {
        return this.email;
    }

    private generateName(): string {
        const name = 'Author Name ';
        const rangeNameId: number = 5000;
        const randomId: number = Math.floor(Math.random() * rangeNameId);
        return name + randomId;
    }

    private generateEmail(): string {
        const nameWithoutWhiteSpace: string = this.name.replace(/\s/g, "");
        return nameWithoutWhiteSpace + '@email.com';
    }
}
