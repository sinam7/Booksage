import React from "react";
import {Card, CardContent} from "@/components/ui/card";
import {IconBookmarkCheck, IconBookmarkX} from "@/components/ui/icon";


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
    return (<Card className="h-[88px]">
        <CardContent className="flex items-center justify-between h-full py-3">
            <div className="flex items-center gap-4">
                <span className="bold text-gray-900 dark:text-gray-100 w-5 text-center">{idx + 1}</span>
                <img
                    alt={title.slice(0, Math.min(title.length, 5))}
                    className="rounded-md flex-shrink-0"
                    height={48}
                    src={imageSrc}
                    style={{
                        aspectRatio: "48/48",
                        objectFit: "cover",
                    }}
                    width={48}
                />
                <div className="space-y-1 min-w-0 max-w-[300px] py-1">
                    <a href={href} target="_blank">
                        <h4 className="font-medium text-gray-900 dark:text-gray-100 truncate group relative">
                            <span className="block truncate group-hover:opacity-0 transition-opacity">
                                {title}
                            </span>
                            <span className="absolute top-0 left-0 w-full opacity-0 group-hover:opacity-100 transition-opacity">
                                <span className={`inline-block whitespace-nowrap ${title.length > 30 ? 'animate-marquee' : ''}`}>
                                    {title}
                                </span>
                            </span>
                        </h4>
                    </a>
                    <div className="text-sm text-gray-500 dark:text-gray-400">
                        <div className="truncate group relative">
                            <span className="block truncate group-hover:opacity-0 transition-opacity">
                                <span>{author}</span>
                                <span className="mx-2">•</span>
                                <span>{publisher}</span>
                            </span>
                            <span className="absolute top-0 left-0 w-full opacity-0 group-hover:opacity-100 transition-opacity">
                                <span className={`inline-block whitespace-nowrap ${(author + publisher).length > 30 ? 'animate-marquee' : ''}`}>
                                    <span>{author}</span>
                                    <span className="mx-2">•</span>
                                    <span>{publisher}</span>
                                </span>
                            </span>
                        </div>
                        <span>{price}</span>
                    </div>
                </div>
            </div>
            {isAvailable ?
                <IconBookmarkCheck className="w-5 h-5 text-green-500 flex-shrink-0"/> :
                <IconBookmarkX className="w-5 h-5 text-red-500 flex-shrink-0"/>}
        </CardContent>
    </Card>);
}