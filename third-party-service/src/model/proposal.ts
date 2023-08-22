import { Author } from "./autor";
import { Product } from "./product";

export class Proposal {

    private readonly product: Product;
    private readonly bidValue: number;
    private readonly author: Author;

    constructor() {
        this.product = new Product();
        this.bidValue = this.generateBidValue();
        this.author = new Author();
    }

    getProduct(): Product {
        return this.product;
    }

    getBidValue(): number {
        return this.bidValue;
    }

    getAuthor(): Author {
        return this.author;
    }

    private generateBidValue(): number {
        const highValue: number = 25000;
        const lowValue: number = 15;
        const value: number = lowValue + Math.random() * (highValue - lowValue);
        return Number(value.toFixed(2));
    }
}