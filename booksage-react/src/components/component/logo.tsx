import Link from "next/link";
import {MountainIcon} from "lucide-react";

export function Logo() {
    return (<div className="flex items-center gap-4">
        <Link className="flex items-center gap-2 text-lg font-semibold" href="#">
            <MountainIcon className="w-6 h-6"/>
            <span className="sr-only">Acme Inc</span>
        </Link>
    </div>);
}