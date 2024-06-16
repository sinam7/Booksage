import React from "react";
import {Card, CardContent} from "@/components/ui/card";
import {CheckIcon, IconBookmarkCheck, IconBookmarkX, XIcon} from "@/components/ui/icon";
import {BookMarkedIcon} from "lucide-react";


interface BookCardProps {
    title: string;
    author: string;
    publisher: string;
    price: string;
    imageSrc: string;
    href: string;
    isAvailable: boolean;
    idx:number;

}

export function BookCard({title, author, publisher, price, imageSrc, href, isAvailable, idx}: BookCardProps) {
    // @ts-ignore
    // @ts-ignore
    return (<Card>
        <CardContent className="flex items-center justify-between mt-4">
            <div className="flex items-center gap-4">
                <span className={"bold"}>{idx + 1}</span>
                <img
                    alt={title.slice(0, Math.min(title.length, 5))}
                    className="rounded-md"
                    height={48}
                    src={imageSrc}
                    style={{
                        aspectRatio: "48/48",
                        objectFit: "cover",
                    }}
                    width={48}
                />
                <div className="space-y-1">
                    <a href={href}><h4 className="font-medium">{title}</h4></a>
                    <div className="text-sm text-gray-500 dark:text-gray-400">
                        <span>{author}</span>
                        <span className="mx-2">•</span>
                        <span>{publisher}</span>
                        <br/>
                        <span>{price}</span>
                    </div>
                </div>
            </div>
            {isAvailable ?
                <IconBookmarkCheck className="w-5 h-5 text-green-500"/> :
                <IconBookmarkX className="w-5 h-5 text-red-500"/>}
        </CardContent>
    </Card>);
}