import {Input} from "@/components/ui/input";
import {Button} from "@/components/ui/button";
import {SearchIcon} from "@/components/ui/icon";


export function SearchComponent(){
    return (<div className="flex items-center gap-2">
        <Input
            className="rounded-md border border-gray-200 border-gray-300 px-3 py-2 focus:outline-none focus:ring-2 focus:ring-gray-500 dark:border-gray-800"
            placeholder="Search..."
            type="search"
        />
        <Button size="icon" variant="ghost">
            <SearchIcon className="w-5 h-5" />
            <span className="sr-only">Search</span>
        </Button>
    </div>);
}